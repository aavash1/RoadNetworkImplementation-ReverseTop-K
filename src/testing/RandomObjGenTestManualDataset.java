package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import algorithm.RandomObjectGenerator;
import framework.Graph;
import framework.RoadObject;

public class RandomObjGenTestManualDataset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Poi poi1 = new Poi(); Poi poi2 = new Poi(); Poi poi3 = new Poi(); Poi poi4 =
		 * new Poi();
		 * 
		 * poi1.setPoiId(1); poi1.setDistanceFromStartNode(2); poi1.setType(true);
		 * 
		 * 
		 * poi2.setPoiId(1); poi2.setDistanceFromStartNode(2); poi2.setType(true);
		 * 
		 * 
		 * poi3.setPoiId(2); poi3.setDistanceFromStartNode(2); poi3.setType(true);
		 * 
		 * poi4.setPoiId(3); poi4.setDistanceFromStartNode(4); poi4.setType(true);
		 * 
		 * Graph gr = new Graph();
		 * 
		 * gr.printPoisOnEdge2(); //gr.printPoisInfo(); gr.addPoi(poi1, 1);
		 * //gr.printPoisInfo(); gr.printPoisOnEdge2(); gr.addPoi(poi2, 1);
		 * //gr.printPoisInfo(); gr.printPoisOnEdge2(); gr.addPoi(poi3, 1);
		 * //gr.printPoisInfo(); gr.printPoisOnEdge2(); gr.addPoi(poi4, 1);
		 * //gr.printPoisInfo(); gr.printPoisOnEdge2();
		 */

		RoadObject poi1 = new RoadObject();
		RoadObject poi2 = new RoadObject();
		RoadObject poi3 = new RoadObject();
		RoadObject poi4 = new RoadObject();
		RoadObject poi5 = new RoadObject();

		Graph gr = new Graph();

		// poi1.setPoiId(100);
		// poi1.setDistanceFromStartNode(2.0);
		// poi1.setType(false);
		//
		// poi2.setPoiId(101);
		// poi2.setDistanceFromStartNode(1.2);
		// poi2.setType(true);
		//
		// poi3.setPoiId(102);
		// poi3.setDistanceFromStartNode(1.8);
		// poi3.setType(false);
		//
		// poi4.setPoiId(103);
		// poi4.setDistanceFromStartNode(1);
		// poi4.setType(true);
		//
		// poi5.setPoiId(100);
		// poi5.setDistanceFromStartNode(1.3);
		// poi5.setType(true);
		//
		//
		// gr.addObjectOnEdge(111, poi1);
		// gr.addObjectOnEdge(111, poi5);
		// // gr.printObjectOnEdge();
		//
		// gr.addObjectOnEdge(112, poi2);
		// // gr.printObjectOnEdge();
		//
		// gr.addObjectOnEdge(113, poi3);
		// gr.addObjectOnEdge(113, poi4);
		// gr.printObjectOnEdge();
		//
		// System.out.println("-------This is another Testing------");
		//
		// gr.addObjectOnEdge3(111, poi1);
		// gr.addObjectOnEdge3(111, poi5);
		// // gr.printObjectOnEdge();
		//
		// gr.addObjectOnEdge3(112, poi2);
		// // gr.printObjectOnEdge();
		//
		// gr.addObjectOnEdge3(113, poi3);
		// gr.addObjectOnEdge3(113, poi4);
		// gr.printObjectOnEdge3();
		//
		//
		// List<Poi> pois = new ArrayList<Poi>();
		// pois.add(poi1);
		// pois.add(poi2);
		// pois.add(poi3);
		// pois.add(poi4);
		// pois.add(poi5);

		gr.addEdge(1, 2, 18.3698);
		gr.addEdge(1, 3, 20.5499);
		gr.addEdge(2, 3, 19.0658);
		gr.addEdge(3, 4, 15.887);
		gr.addEdge(3, 5, 17.01466);
		gr.addEdge(5, 6, 23.963);
		gr.addEdge(4, 6, 22.17489);
		gr.addEdge(6, 7, 21.12365);
		gr.addEdge(7, 8, 24.4421);

		// gr.printEdgesInfo();
		// gr.printGraph();
		// gr.printObjectOnEdge3();
		// gr.addObjectOnEdge3(1, poi1);

		// ranG.generateRandomObjectsOnMap(gr);
		// ranG.generateRandomObjectsOnMap2(gr);
		// RandomObjectGenerator.generateRandomObjectsOnMap(gr);
		System.out.println("---This is after generator------");
		// gr.printGraph();
		gr.printObjectsOnEdges();

		RandomObjectGenerator.printStatistics();

		// randomDistanceGeneratorTest();

	}

	public static void randomDistanceGeneratorTest() {
		System.out.println("Random acceptable distance generator");
		Boolean isThereDistanceConflict = false;
		ArrayList<Double> randomDistances2 = new ArrayList<Double>();
		double distanceFromStartNode;
		double minDistanceBetPois = 3;

		randomDistances2.add(12.0);
		randomDistances2.add(4.0);
		distanceFromStartNode = 7.0;
		for (int k = 0; k < randomDistances2.size(); k++) {
			if (!((randomDistances2.get(k) + minDistanceBetPois <= distanceFromStartNode)
					|| (randomDistances2.get(k) - minDistanceBetPois >= distanceFromStartNode))) {
				isThereDistanceConflict = true;
			}
		}
		for (int k = 0; k < randomDistances2.size(); k++) {
			System.out.println("chosen distance " + k + ": " + randomDistances2.get(k));
		}

		System.out.println("minDistanceBetPois: " + minDistanceBetPois + ", " + "Random distance from SN: "
				+ distanceFromStartNode);
		System.out.println("isThereDistanceConflict: " + isThereDistanceConflict);
	}

}
