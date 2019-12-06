package testing;

import java.util.LinkedList;
import java.util.Map;

import algorithm.ANNClustered;
import algorithm.ANNNaive;

import algorithm.ClusteringRoadObjects;
import algorithm.RandomObjectGenerator;
import framework.Graph;

import framework.UtilsManagment;

public class ANNEvaluationOldenRealDatasetTest {

	public static void main(String[] args) {
		Graph oldenGraph = new Graph("Oldenburg");

		String nodeDatasetFile = "Datasets/OLDN-Node_NId-NLong-NLat.csv";
		String edgeDatasetFile = "Datasets/OLDN-Edge_Eid-ESrc-EDest-EDist.csv";
		UtilsManagment.readEdgeFile(oldenGraph, edgeDatasetFile);
		UtilsManagment.readNodeFile(oldenGraph, nodeDatasetFile);

		LinkedList<Integer> queryParams = new LinkedList<Integer>();
		LinkedList<Integer> dataParams = new LinkedList<Integer>();
		queryParams.add(10000);
		queryParams.add(10000);
		queryParams.add(10000);
		queryParams.add(10000);
		queryParams.add(10000);
		queryParams.add(20000);
		queryParams.add(30000);
		queryParams.add(50000);
		queryParams.add(70000);
		queryParams.add(100000);

		dataParams.add(20000);
		dataParams.add(30000);
		dataParams.add(50000);
		dataParams.add(70000);
		dataParams.add(100000);
		dataParams.add(10000);
		dataParams.add(10000);
		dataParams.add(10000);
		dataParams.add(10000);
		dataParams.add(10000);

		Map<Integer, LinkedList<Integer>> nodeClusterFromFile = UtilsManagment
				.readNodeClustersFile("ClusterDatasets/Oldenburg_node-clusters_2019-12-06 17-54-10.csv");

		String graphName = oldenGraph.getDatasetName();

		String evaluationResultFile = "ResultFiles/" + graphName + "_" + "_ANNs-Naive-Clustereds_"
				+ UtilsManagment.getNormalDateTime() + ".csv";
		while (!queryParams.isEmpty()) {
			int queryObjNum = queryParams.poll();
			int dataObjNum = dataParams.poll();

			for (int i = 0; i < 10; i++) {
				RandomObjectGenerator.generateRandomObjectsOnMap6(oldenGraph, queryObjNum, dataObjNum);
				// RandomObjectGenerator.printStatistics();

				String roadObjsOnEdgeCSVFile = "GeneratedFiles/" + graphName + "_Q_" + queryObjNum + "_D_" + dataObjNum
						+ UtilsManagment.getNormalDateTime() + ".csv";

				UtilsManagment.writeRoadObjsOnEdgeFile(oldenGraph.getObjectsOnEdges(), oldenGraph.getDatasetName(),
						roadObjsOnEdgeCSVFile);

				// Map<Integer, ArrayList<RoadObject>> objectsOnEdge =
				// UtilsManagment.readRoadObjectFile(roadObjsOnEdgeCSVFile);
				// calGraph.setObjectsOnEdges(objectsOnEdge);

				ANNNaive annNaive = new ANNNaive();
				long startTimeNaive = System.nanoTime();
				annNaive.compute(oldenGraph, true);
				long computationTimeNaive = System.nanoTime() - startTimeNaive;
				double computationTimeDNaive = (double) computationTimeNaive / 1000000000.0;
				// annNaive.printNearestNeighborSets();
				System.out.println("Time to compute Naive ANN: " + computationTimeDNaive);

				ClusteringRoadObjects clusteringObjects = new ClusteringRoadObjects();
				Map<Integer, LinkedList<Integer>> objectIdClusters = clusteringObjects.clusterWithIndex(oldenGraph,
						nodeClusterFromFile, true);

				ANNClustered annClustered = new ANNClustered();
				long startTimeClustered = System.nanoTime();
				annClustered.computeWithoutClustering(oldenGraph, true, nodeClusterFromFile, objectIdClusters);
				long computationTimeClustered = System.nanoTime() - startTimeClustered;
				double computationTimeDClustered = (double) computationTimeClustered / 1000000000.0;
				// ann3.printNearestSets();
				System.out.println("Time to compute Clustered ANN: " + computationTimeDClustered);
				System.out.println();

				UtilsManagment.writeFinalEvaluationResult(oldenGraph, evaluationResultFile, computationTimeDNaive,
						computationTimeDClustered);
			}
		}

	}

}
