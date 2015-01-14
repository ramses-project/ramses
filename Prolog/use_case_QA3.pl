:-use_module(solutions_helpers).
:-use_module(use_case_implications).

%model_elements([cnx1, cnx2, p11, p12, p21, p22]).
model_elements([1, 2, 11, 12, 21, 22]).
transfo_rules([t1, t2, t3, t4, t5, t6, t7]).	

canApply(1, t1).
canApply(1, t2).
canApply(1, t3).

canApply(2, t1).
canApply(2, t2).
canApply(2, t3).

canApply(22, t4).
canApply(11, t4).

canApply(21, t5).
canApply(12, t5).

canApply(22, t6).
canApply(11, t6).

canApply(21, t7).
canApply(12, t7).

% Dependency constraints
% Dependencies must have been set as disjunctions of conjunctions

imply((2,t2),Affectation):-
	member((2,t2),Affectation),
	member((21,t7),Affectation),
	member((22,t6),Affectation)
	.

imply((2,t2),Affectation):-
	\+ member((2,t2),Affectation)
	.

imply((2,t2),Affectation):-
	fail.

imply((_,_),[]).

checkImplications(PotentialSolution):-
	imply((2,t2),PotentialSolution).
