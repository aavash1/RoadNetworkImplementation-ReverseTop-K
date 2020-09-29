package experiment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import algorithm.ANNClusteredOptimizedWithHeuristic;
import algorithm.ANNNaive;

import algorithm.RandomObjectGenerator;
import algorithm.VivetAlgorithm;
import framework.Graph;
import framework.UtilsManagment;
import road_network.CaliforniaRN;

public class SQORN2_ANNEvaluationCal {

	public static void main(String[] args) {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

		double perimeter = 1.68;

		// RandomObjectGeneration
		// <C, U> sanFraGraphCU1, sanFraGraphCU2, sanFraGraphCU3, sanFraGraphCU4
		// <U, C> sanFraGraphUC1, sanFraGraphUC2, sanFraGraphUC3, sanFraGraphUC4
		// <C, C> sanFraGraphCC1, sanFraGraphCC2, sanFraGraphCC3, sanFraGraphCC4
		// <U, U> sanFraGraphUU1, sanFraGraphUU2, sanFraGraphUU3, sanFraGraphUU4

		// NAIVE ///////////////////////
		// <C, U> sanFraGraphCU x 4
		// <U, C> sanFraGraphUC x 4
		// <C, C> sanFraGraphCC x4
		// <U, U> sanFraGraphUU x4

		// VIVET ///////////////////////
		// <C, U> sanFraGraphCU x4
		// <U, C> sanFraGraphUC x 4
		// <C, C> sanFraGraphCC x 4
		// <U, U> sanFraGraphUU x 4

		// CLUSTERED ///////////////////////
		// <C, U> sanFraGraphCU x 4
		// <U, C> sanFraGraphUC x 4
		// <C, C> sanFraGraphCC x 4
		// <U, U> sanFraGraphUU x 4

		Graph calGraphCU1 = new Graph();
		Graph calGraphCU2 = new Graph();
		Graph calGraphCU3 = new Graph();
		Graph calGraphCU4 = new Graph();

		Graph calGraphUC1 = new Graph();
		Graph calGraphUC2 = new Graph();
		Graph calGraphUC3 = new Graph();
		Graph calGraphUC4 = new Graph();

		Graph calGraphCC1 = new Graph();
		Graph calGraphCC2 = new Graph();
		Graph calGraphCC3 = new Graph();
		Graph calGraphCC4 = new Graph();

		Graph calGraphUU1 = new Graph();
		Graph calGraphUU2 = new Graph();
		Graph calGraphUU3 = new Graph();
		Graph calGraphUU4 = new Graph();

		ArrayList<Graph> listOfGraphs = new ArrayList<Graph>();

		calGraphCU1 = CaliforniaRN.getGraph();// 0
		listOfGraphs.add(calGraphCU1);
		Graph califroniaGraph = new Graph();
		califroniaGraph = CaliforniaRN.getGraph();
		listOfGraphs.add(califroniaGraph);
		calGraphCU2 = CaliforniaRN.getGraph(); // 1
		listOfGraphs.add(calGraphCU2);
		calGraphCU3 = CaliforniaRN.getGraph(); // 2
		listOfGraphs.add(calGraphCU3);
		calGraphCU4 = CaliforniaRN.getGraph(); // 3
		listOfGraphs.add(calGraphCU4);
		calGraphUC1 = CaliforniaRN.getGraph(); // 4...
		listOfGraphs.add(calGraphUC1);
		calGraphUC2 = CaliforniaRN.getGraph(); // 5
		listOfGraphs.add(calGraphUC2);
		calGraphUC3 = CaliforniaRN.getGraph(); // 6
		listOfGraphs.add(calGraphUC3);
		calGraphUC4 = CaliforniaRN.getGraph(); // 7
		listOfGraphs.add(calGraphUC4);
		calGraphCC1 = CaliforniaRN.getGraph(); // 8...
		listOfGraphs.add(calGraphCC1);
		calGraphCC2 = CaliforniaRN.getGraph(); // 9
		listOfGraphs.add(calGraphCC2);
		calGraphCC3 = CaliforniaRN.getGraph(); // 10
		listOfGraphs.add(calGraphCC3);
		calGraphCC4 = CaliforniaRN.getGraph(); // 11
		listOfGraphs.add(calGraphCC4);
		calGraphUU1 = CaliforniaRN.getGraph(); // 12...
		listOfGraphs.add(calGraphUU1);
		calGraphUU2 = CaliforniaRN.getGraph(); // 13
		listOfGraphs.add(calGraphUU2);
		calGraphUU3 = CaliforniaRN.getGraph(); // 14
		listOfGraphs.add(calGraphUU3);
		calGraphUU4 = CaliforniaRN.getGraph(); // 15
		listOfGraphs.add(calGraphUU4);

		for (int i = 0; i < listOfGraphs.size(); i++) {
			System.out.println("The dataset is :" + listOfGraphs.get(i).getDatasetName() + " with edges: "
					+ listOfGraphs.get(i).getNumberOfEdges());
		}

		LinkedList<Integer> queryParams = new LinkedList<Integer>();
		LinkedList<Integer> dataParams = new LinkedList<Integer>();
		// queryParams.add(1000);
		queryParams.add(30000);
		queryParams.add(30000);
		queryParams.add(30000);
		queryParams.add(30000);
		queryParams.add(30000);
		queryParams.add(20000);
		queryParams.add(30000);
		queryParams.add(50000);
		queryParams.add(70000);
		queryParams.add(100000);

		// dataParams.add(1000);
		dataParams.add(20000);
		dataParams.add(30000);
		dataParams.add(50000);
		dataParams.add(70000);
		dataParams.add(100000);
		dataParams.add(30000);
		dataParams.add(30000);
		dataParams.add(30000);
		dataParams.add(30000);
		dataParams.add(30000);

		String evaluationResultFile = "ResultFiles/" + "California" + "_" + "_ANNs-Naive-Clustereds_VIVET"
				+ UtilsManagment.getNormalDateTime() + ".csv";

		while (!queryParams.isEmpty()) {
			int queryObjNum = queryParams.poll();
			int dataObjNum = dataParams.poll();

			// <C, U>
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphCU1, queryObjNum, dataObjNum, true,
					perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphCU2, queryObjNum, dataObjNum, true,
					perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphCU3, queryObjNum, dataObjNum, true,
					perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphCU4, queryObjNum, dataObjNum, true,
					perimeter);

			// <U, C>
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphUC1, queryObjNum, dataObjNum, false,
					perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphUC2, queryObjNum, dataObjNum, false,
					perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphUC3, queryObjNum, dataObjNum, false,
					perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgesWithCentroid(calGraphUC4, queryObjNum, dataObjNum, false,
					perimeter);

			// <C, C>
			RandomObjectGenerator.generateRandomObjectsOnEdgeWithCentroidForSameDistribution(calGraphCC1, queryObjNum,
					dataObjNum, perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgeWithCentroidForSameDistribution(calGraphCC2, queryObjNum,
					dataObjNum, perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgeWithCentroidForSameDistribution(calGraphCC3, queryObjNum,
					dataObjNum, perimeter);
			RandomObjectGenerator.generateRandomObjectsOnEdgeWithCentroidForSameDistribution(calGraphCC4, queryObjNum,
					dataObjNum, perimeter);

			// <U, U>
			RandomObjectGenerator.generateRandomObjectsOnMap6(calGraphUU1, queryObjNum, dataObjNum);
			RandomObjectGenerator.generateRandomObjectsOnMap6(calGraphUU2, queryObjNum, dataObjNum);
			RandomObjectGenerator.generateRandomObjectsOnMap6(calGraphUU3, queryObjNum, dataObjNum);
			RandomObjectGenerator.generateRandomObjectsOnMap6(calGraphUU4, queryObjNum, dataObjNum);

			// NAIVE
			for (int i = 0; i < listOfGraphs.size(); i++) {
				String algoType = "Naive-ANN";
				String distributionCat;

				if (i < 4) {
					distributionCat = "<C,U>";
				} else if (i < 8) {
					distributionCat = "<U,C>";

				} else if (i < 12) {
					distributionCat = "<C,C>";
				} else {
					distributionCat = "<U,U>";
				}
				ANNNaive annNaive = new ANNNaive();
				long startTimeNaive = System.nanoTime();
				annNaive.compute(listOfGraphs.get(i), true);
				long computationTimeNaive = System.nanoTime() - startTimeNaive;
				double computationTimeDNaive = (double) computationTimeNaive / 1000000000.0;
				// annNaive.printNearestNeighborSets();
				System.out.println("Time to compute Naive ANN: " + computationTimeDNaive);
				UtilsManagment.writeFinalEvaluationResult(listOfGraphs.get(i), evaluationResultFile, algoType,
						queryObjNum, dataObjNum, distributionCat, computationTimeDNaive);
				// make new write, writer for separate algorithms
				// UtilsManagment.writeFinalEvaluationResult(listOfGraphs.get(i),
				// evaluationResultFile, computationTimeDNaive, computationTimeDClustered,
				// distributionCat);

			}

			// VIVET
			for (int i = 0; i < listOfGraphs.size(); i++) {
				String algoType = "VIVET";
				String distributionCat;

				if (i < 4) {
					distributionCat = "<C,U>";
				} else if (i < 8) {
					distributionCat = "<U,C>";

				} else if (i < 12) {
					distributionCat = "<C,C>";
				} else {
					distributionCat = "<U,U>";
				}

				VivetAlgorithm annVivet = new VivetAlgorithm();
				long startTimeVivet = System.nanoTime();
				annVivet.compute(listOfGraphs.get(i));
				long computationTimeVivet = System.nanoTime() - startTimeVivet;
				double computationTimeDVivet = (double) computationTimeVivet / 1000000000.0;
				// annVivet.printNearestNeighborSets();
				System.out.println("Time to compute VIVET ANN: " + computationTimeDVivet);

				// make new writer, writer for separate algorithms
				UtilsManagment.writeFinalEvaluationResult(listOfGraphs.get(i), evaluationResultFile, algoType,
						queryObjNum, dataObjNum, distributionCat, computationTimeDVivet);

			}

			// CLUSTERED

			// TODO: find for California
			Map<Integer, LinkedList<Integer>> nodeClusterFromFile = UtilsManagment
					.readNodeClustersFile("ClusterDatasets/California_node-clusters_2019-12-06 17-35-41.csv");

			for (int i = 0; i < listOfGraphs.size(); i++) {
				String algoType = "CLUSTERED";
				String distributionCat;

				if (i < 4) {
					distributionCat = "<C,U>";
				} else if (i < 8) {
					distributionCat = "<U,C>";

				} else if (i < 12) {
					distributionCat = "<C,C>";
				} else {
					distributionCat = "<U,U>";
				}

				ANNClusteredOptimizedWithHeuristic annClustered = new ANNClusteredOptimizedWithHeuristic();
				long startTimeClustered = System.nanoTime();
				annClustered.computeWithTimeAndHeuristicWithoutClustering(listOfGraphs.get(i), true,
						nodeClusterFromFile);
				long computationTimeClustered = System.nanoTime() - startTimeClustered;
				double computationTimeDClustered = (double) computationTimeClustered / 1000000000.0;
				// annClustered.printNearestNeighborSets();
				System.out.println("Time to compute Clustered ANN: " + computationTimeDClustered);
				UtilsManagment.writeFinalEvaluationResult(listOfGraphs.get(i), evaluationResultFile, algoType,
						queryObjNum, dataObjNum, distributionCat, computationTimeDClustered);
				// make new writer, writer for separate algorithms
				// UtilsManagment.writeFinalEvaluationResult(listOfGraphs.get(i),
				// evaluationResultFile, computationTimeDNaive, computationTimeDClustered,
				// distributionCat);

			}

			//

		}

	}
}