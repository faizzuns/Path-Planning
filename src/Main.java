import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph();
        Map<Pair<String, String>, Integer> mapHeuristic = new HashMap<>();

        String file = "D:\\CompetitiveProgramming\\CsAcademy\\PathPlaning\\src\\data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String sCurrentLine = br.readLine();
            ArrayList<String> data = new ArrayList<>();

            while ((sCurrentLine = br.readLine()) != null && !sCurrentLine.equals("HEURISTIC")) {
                String[] parse = sCurrentLine.split(" ");
                graph.addEdge(parse[0], parse[1], Integer.parseInt(parse[2]), true);
            }

            while ((sCurrentLine = br.readLine()) != null){
                String[] parse = sCurrentLine.split(" ");
                mapHeuristic.put(new Pair<>(parse[0], parse[1]), Integer.parseInt(parse[2]));
                mapHeuristic.put(new Pair<>(parse[1], parse[0]), Integer.parseInt(parse[2]));
            }


        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        graph.printGraph();

        for (Pair<String, String> key : mapHeuristic.keySet()){
            System.out.println(key.getKey() + " - " + key.getValue() + " = " + mapHeuristic.get(key));
        }

        String from = "A";
        String destination = "D";
        List<String> result = new ArrayList<>();
        graph.AStarAlgorithm(mapHeuristic, from, destination, result);

    }
}
