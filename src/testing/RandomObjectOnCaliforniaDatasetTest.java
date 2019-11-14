package testing;

import algorithm.RandomObjectGenerator;
import framework.Graph;
import framework.UtilsManagment;

public class RandomObjectOnCaliforniaDatasetTest {
	public static void main(String[] args) {
		UtilsManagment um = new UtilsManagment();
		Graph calGraph = new Graph("California");

		String nodeDatasetFile = "Datasets/CAL-Node_NId-NLong-NLat.csv";
		String edgeDatasetFile = "Datasets/CAL-Edge_Eid-ESrc-EDest-EDist.csv";

		um.readEdgeFile(calGraph, edgeDatasetFile);
		um.readNodeFile(calGraph, nodeDatasetFile);
		// calGraph.printGraph();

		RandomObjectGenerator.generateRandomObjectsOnMap(calGraph, 10000, 50000);
		RandomObjectGenerator.printStatistics();
		System.out.println("Finished Generating");
		um.writeRoadObjsOnEdgeFile(calGraph.getObjectsOnEdges(), calGraph.getDatasetName());
		um.writeDatasetStatistics(calGraph);
		// calGraph.printObjectsOnEdges();

	}

}
