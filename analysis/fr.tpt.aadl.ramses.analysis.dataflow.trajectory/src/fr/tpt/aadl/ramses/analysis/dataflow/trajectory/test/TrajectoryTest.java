package fr.tpt.aadl.ramses.analysis.dataflow.trajectory.test;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.control.Algorithm ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Flow ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Network ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Node ;
import fr.tpt.aadl.ramses.analysis.dataflow.trajectory.model.Path ;

public class TrajectoryTest
{

  public static void main (String [] arg) {
    Flow f1 = new Flow();
    f1.setPeriod(36);
    f1.setPriority(10);
    f1.setDeadline(36);
    f1.setJitter(0);
    
    Flow f2 = new Flow();
    f2.setPeriod(36);
    f2.setPriority(10);
    f2.setDeadline(36);
    f2.setJitter(0);
    
    Flow f3 = new Flow();
    f3.setPeriod(36);
    f3.setPriority(11);
    f3.setDeadline(54);
    f3.setJitter(0);
    
    Flow f4 = new Flow();
    f4.setPeriod(36);
    f4.setPriority(11);
    f4.setDeadline(54);
    f4.setJitter(0);
    
    Flow f5 = new Flow();
    f5.setPeriod(36);
    f5.setPriority(12);
    f5.setDeadline(45);
    f5.setJitter(0);
    
    Node n1 = new Node();
    n1.setId("n1");
    Map<Flow,Integer> n1_capacity = new HashMap<Flow,Integer>();
    n1_capacity.put(f1,4);
    n1.setCapacity((HashMap<Flow, Integer>) n1_capacity);
    
    Node n2 = new Node();
    n2.setId("n2");
    Map<Flow,Integer> n2_capacity = new HashMap<Flow,Integer>();
    n2_capacity.put(f3,4);
    n2_capacity.put(f4,4);
    n2_capacity.put(f5,4);
    n2.setCapacity((HashMap<Flow, Integer>) n2_capacity);
    
    Node n3 = new Node();
    n3.setId("n3");
    Map<Flow,Integer> n3_capacity = new HashMap<Flow,Integer>();
    n3_capacity.put(f1,4);
    n3_capacity.put(f3,4);
    n3_capacity.put(f4,4);
    n3_capacity.put(f5,4);
    n3.setCapacity((HashMap<Flow, Integer>) n3_capacity);
    
    Node n4 = new Node();
    n4.setId("n4");
    Map<Flow,Integer> n4_capacity = new HashMap<Flow,Integer>();
    n4_capacity.put(f1,4);
    n4_capacity.put(f3,4);
    n4_capacity.put(f4,4);
    n4_capacity.put(f5,4);
    n4.setCapacity((HashMap<Flow, Integer>) n4_capacity);
    
    Node n5 = new Node();
    n5.setId("n5");
    Map<Flow,Integer> n5_capacity = new HashMap<Flow,Integer>();
    n5_capacity.put(f1,4);
    n5.setCapacity((HashMap<Flow, Integer>) n5_capacity);
    
    Node n6 = new Node();
    n6.setId("n6");
    Map<Flow,Integer> n6_capacity = new HashMap<Flow,Integer>();
    n6_capacity.put(f2,4);
    n6.setCapacity((HashMap<Flow, Integer>) n6_capacity);
    
    Node n7 = new Node();
    n7.setId("n7");
    Map<Flow,Integer> n7_capacity = new HashMap<Flow,Integer>();
    n7_capacity.put(f2,4);
    n7_capacity.put(f3,4);
    n7_capacity.put(f4,4);
    n7_capacity.put(f5,4);
    n7.setCapacity((HashMap<Flow, Integer>) n7_capacity);
    
    Node n8 = new Node();
    n8.setId("n8");
    Map<Flow,Integer> n8_capacity = new HashMap<Flow,Integer>();
    n8_capacity.put(f5,4);
    n8.setCapacity((HashMap<Flow, Integer>) n8_capacity);
    
    Node n9 = new Node();
    n9.setId("n9");
    Map<Flow,Integer> n9_capacity = new HashMap<Flow,Integer>();
    n9_capacity.put(f2,4);
    n9.setCapacity((HashMap<Flow, Integer>) n9_capacity);
    
    Node n10 = new Node();
    n10.setId("n10");
    Map<Flow,Integer> n10_capacity = new HashMap<Flow,Integer>();
    n10_capacity.put(f2,4);
    n10_capacity.put(f3,4);
    n10_capacity.put(f4,4);
    n10.setCapacity((HashMap<Flow, Integer>) n10_capacity);
    
    Node n11 = new Node();
    n11.setId("n11");
    Map<Flow,Integer> n11_capacity = new HashMap<Flow,Integer>();
    n11_capacity.put(f3,4);
    n11_capacity.put(f4,4);
    n11.setCapacity((HashMap<Flow, Integer>) n11_capacity);
    
    List<Node> nodes = new ArrayList<Node>();
    nodes.add(n1);
    nodes.add(n2);
    nodes.add(n3);
    nodes.add(n4);
    nodes.add(n5);
    nodes.add(n6);
    nodes.add(n7);
    nodes.add(n8);
    nodes.add(n9);
    nodes.add(n10);
    nodes.add(n11);
    
    List<Node> p1Nodes = new ArrayList<Node>();
    p1Nodes.add(n1);
    p1Nodes.add(n3);
    p1Nodes.add(n4);
    p1Nodes.add(n5);
    Path p1 = new Path(p1Nodes);
    f1.setPath(p1);
    
    List<Node> p2Nodes = new ArrayList<Node>();
    p2Nodes.add(n9);
    p2Nodes.add(n10);
    p2Nodes.add(n7);
    p2Nodes.add(n6);
    Path p2 = new Path(p2Nodes);
    f2.setPath(p2);
    
    List<Node> p3Nodes = new ArrayList<Node>();
    p3Nodes.add(n2);
    p3Nodes.add(n3);
    p3Nodes.add(n4);
    p3Nodes.add(n7);
    p3Nodes.add(n10);
    p3Nodes.add(n11);
    Path p3 = new Path(p3Nodes);
    f3.setPath(p3);
    
    List<Node> p4Nodes = new ArrayList<Node>();
    p4Nodes.add(n2);
    p4Nodes.add(n3);
    p4Nodes.add(n4);
    p4Nodes.add(n7);
    p4Nodes.add(n10);
    p4Nodes.add(n11);
    Path p4 = new Path(p4Nodes);
    f4.setPath(p4);
    
    List<Node> p5Nodes = new ArrayList<Node>();
    p5Nodes.add(n2);
    p5Nodes.add(n3);
    p5Nodes.add(n4);
    p5Nodes.add(n7);
    p5Nodes.add(n8);
    Path p5 = new Path(p5Nodes);
    f5.setPath(p5);
    
    List<Flow> flows = new ArrayList<Flow>();
    flows.add(f1);
    flows.add(f2);
    flows.add(f3);
    flows.add(f4);
    flows.add(f5);
    
    
    Network n = new Network(flows, nodes, 1, 1);
    n.init();
    
    Algorithm algo = new Algorithm(n);
    
    List<Integer> results = algo.computeWorstCaseEndToEndResponse();
    System.out.println("Results: ");
    for(Integer i:results)
      System.out.println(i);
    return;
  }
}
