/*
  Example of initialization, to be generated from TRC,
  pattern matching
  and other Java components

*/
:-use_module(solutions_helpers).
:-use_module(use_case_implications).

%model_elements([cnx1, cnx2, cnx3, cnx4, cnx5, cnx6, cnx7, cnx8, cnx9, cnx10,
%		 bus_A, bus_B, bus_gwt, 
%                p1_A, p2_A, p3_A, p1_B, p2_B, p3_B, p1_sw, p2_sw, p3_sw, p4_sw, p5_sw, p1_gwt, p2_gwt, p3_gwt]).
model_elements([cnx1,cnx2,cnx3,cnx4,cnx5,cnx6,cnx7,cnx8,cnx9,cnx10,bus_A,bus_B,bus_gwt,p1_A,p2_A,p3_A,p1_B,p2_B,p3_B,p1_sw,p2_sw,p3_sw,p4_sw,p5_sw,p1_gwt,p2_gwt,p3_gwt]).
transfo_rules([t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16]).	

canApply(cnx1, t1).
canApply(cnx2, t1).
canApply(cnx3, t1).
canApply(cnx4, t1).
canApply(cnx5, t1).

canApply(cnx1, t2).
canApply(cnx2, t2).
canApply(cnx3, t2).
canApply(cnx4, t2).
canApply(cnx5, t2).

canApply(cnx6, t3).
canApply(cnx7, t3).
canApply(cnx8, t3).
canApply(cnx9, t3).
canApply(cnx10,t3).

canApply(cnx6, t4).
canApply(cnx7, t4).
canApply(cnx8, t4).
canApply(cnx9, t4).
canApply(cnx10,t4).

canApply(bus_A, t5).
canApply(bus_B, t5).
canApply(bus_gwt, t5).

canApply(bus_A, t6).
canApply(bus_B, t6).
canApply(bus_gwt, t6).

canApply(p1_A, t7).
canApply(p2_A, t7).
canApply(p3_A, t7).

canApply(p1_B, t8).
canApply(p2_B, t8).
canApply(p3_B, t8).

canApply(p1_A, t9).
canApply(p2_A, t9).
canApply(p3_A, t9).

canApply(p1_B, t10).
canApply(p2_B, t10).
canApply(p3_B, t10).

canApply(p1_sw, t11).
canApply(p2_sw, t11).
canApply(p3_sw, t11).
canApply(p4_sw, t11).
canApply(p5_sw, t11).

canApply(p1_sw, t12).
canApply(p2_sw, t12).
canApply(p3_sw, t12).
canApply(p4_sw, t12).
canApply(p5_sw, t12).

canApply(p1_sw, t13).
canApply(p2_sw, t13).
canApply(p3_sw, t13).
canApply(p4_sw, t13).
canApply(p5_sw, t13).

canApply(p1_sw, t14).
canApply(p2_sw, t14).
canApply(p3_sw, t14).
canApply(p4_sw, t14).
canApply(p5_sw, t14).

canApply(p1_gwt, t15).
canApply(p2_gwt, t15).
canApply(p3_gwt, t15).

canApply(p1_gwt, t16).
canApply(p2_gwt, t16).
canApply(p3_gwt, t16).


% Dependency constraints
% Dependencies must have been set as disjunctions of conjunctions

imply((cnx2,t2),Affectation):-
	member((cnx2,t2),Affectation),
	member((cnx4,t2),Affectation),	
	member((cnx9,t3),Affectation),
	member((cnx10,t4),Affectation),
	member((bus_gwt,t6),Affectation),
	member((p3_B,t8),Affectation),
	member((p3_A,t9),Affectation),
	member((p3_sw,t13),Affectation),
	member((p4_sw,t14),Affectation),
	member((p3_gwt,t16),Affectation)
	.

imply((cnx2,t2),Affectation):-
	\+ member((cnx2,t2),Affectation)
	.

imply((cnx2,t2),Affectation):-
	fail.

imply((_,_),[]).

checkImplications(PotentialSolution):-
	imply((cnx2,t2),PotentialSolution).
