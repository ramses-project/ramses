:-use_module(solutions_helpers).
:-use_module(use_case_implications).

%model_elements([cnx1, cnx2, cnx3, cnx4, p12, p21, p23, p32, p34, p43, p41, p14]).
model_elements([1, 2, 3, 4, 12, 21, 23, 32, 34, 43, 41, 14]).
transfo_rules([t1, t2, t3, t11, t22, t33, t44]).

canApply(1, t1).
canApply(1, t2).
canApply(1, t3).

canApply(2, t1).
canApply(2, t2).
canApply(2, t3).

canApply(3, t1).
canApply(3, t2).
canApply(3, t3).

canApply(4, t1).
canApply(4, t2).
canApply(4, t3).

canApply(12, t11).
canApply(14, t11).

canApply(21, t22).
canApply(23, t22).

canApply(32, t33).
canApply(34, t33).

canApply(41, t44).
canApply(43, t44).

canApply(41, t11).
canApply(21, t11).

canApply(12, t22).
canApply(32, t22).

canApply(43, t33).
canApply(23, t33).

canApply(34, t44).
canApply(14, t44).

% Dependency constraints
% Dependencies must have been set as disjunctions of conjunctions

imply((3,t3),Affectation):-
	member((3,t3),Affectation),
	member((43,t33),Affectation),
	member((23,t33),Affectation)
	.

imply((3,t3),Affectation):-
	\+ member((2,t2),Affectation)
	.

imply((3,t3),Affectation):-
	fail.

imply((_,_),[]).

checkImplications(PotentialSolution):-
	imply((3,t3),PotentialSolution).