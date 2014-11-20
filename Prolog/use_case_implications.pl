% Dependency constraints
% Dependencies must have been set as disjunctions of conjunctions

:-module(use_case_implications, [checkImplications/1]).

imply((21,t11),Affectation):-
	member((21,t11),Affectation),
	member((22,t12),Affectation)
	.

imply((21,t11),Affectation):-
	member((21,t11),Affectation),
	member((22,t22),Affectation)
	.

imply((21,t11),Affectation):-
	\+ member((21,t11),Affectation)
	.

imply((21,t11),Affectation):-
	fail.

imply((_,_),[]).

checkImplications(PotentialSolution):-
	imply((21,t11),PotentialSolution).
