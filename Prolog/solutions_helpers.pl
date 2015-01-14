

:-module(solutions_helpers, [sublist/2,
			     crossOverPositions/3,
			     allCrossOver/3,
			     crossOverSubset/4,
			     computeAllAffectations/3,
			     computeAffectationsSubset/4
			     ]).

sublist( [], _ ).
sublist( [X|XS], [X|XSS] ) :- sublist( XS, XSS ).
sublist( [X|XS], [_|XSS] ) :- sublist( [X|XS], XSS ).
sublist( [X], [Y] ) :- X==Y.

quick_sort2(List,Sorted):-q_sort(List,[],Sorted).

q_sort([(H,I)|T],Acc,Sorted):-
	pivoting((H,I),T,L1,L2),
	q_sort(L1,Acc,Sorted1),q_sort(L2,[(H,I)|Sorted1],Sorted).
q_sort([],Acc,Acc).

pivoting((H,_),[(X,Y)|T],L,[(X,Y)|G]):-X=<H,pivoting((H,_),T,L,G).
pivoting((H,_),[(X,Y)|T],[(X,Y)|L],G):-X>H,pivoting((H,_),T,L,G).
pivoting((_,_),[],[],[]).
	
partition(P1,P2,Union):-
	sublist(P1,Union),
	findall(X,
		(
		 member(X,Union),
		 \+member(X,P1))
	       ,P2),
	append(P1,P2,Res),
	Res==Union.



allMutations(OldSolution, Position, NewSolutions):-
	length(OldSolution, NbOfElements),
	ActualPosition is Position-1,
	findall(MutatedSolution,
		(
		 partition(Left,[(X,Mutant)|Right],OldSolution),
		 length(Left,ActualPosition),
		 findall(Rule, canApply(X, Rule), PossibleMutations),
		 member(Mutated,PossibleMutations),
		 append(Left,[(X,Mutated)|Right],MutatedSolution),
		 Mutated\==Mutant,
		 checkSolution(MutatedSolution),
		 length(MutatedSolution, NbOfElements)
		 ),
	       NewSolutions) 
	.

crossOverPositions(L1,L2,Positions):-
	length(L1,NbOfElements),
	findall(N,
		(
		 partition(Left1,Right1,L1),
		 length(Left1,N),0<N,N<NbOfElements,
		 findall(
			 (Attr,_),
			 (member((Attr,_),Right1)),
			  Right2
			 ),
		 partition(Left2,Right2,L2),
		 append(Left2,Right1,Prod1),
		 append(Left1,Right2,Prod2),
		 checkSolution(Prod1),
		 checkSolution(Prod2),
		 length(Prod1, NbOfElements),
		 length(Prod2, NbOfElements),
		 %quick_sort2(Prod1,SortedProd1),
		 Prod1\==L1,
		 Prod1\==L2,
		 %quick_sort2(Prod2,SortedProd2),
		 Prod2\==L1,
		 Prod2\==L2
		),
		P),
	sort(P, Positions)
	.

allCrossOver(L1,L2,Products):-
	length(L1,NbOfElements),
	findall(SortedProd,
		(
		 partition(Left1,Right1,L1),
		 length(Left1,N1),0<N1,N1<NbOfElements,
		 findall(
			 (Attr,_),
			 (member((Attr,_),Right1)),
			  Right2
			 ),
		 partition(Left2,Right2,L2),
		 append(Left2,Right1,Prod),
		 checkSolution(Prod),
		 length(Prod, NbOfElements),
		 quick_sort2(Prod,SortedProd),
		 SortedProd\==L1,
		 SortedProd\==L2
		),
		Products)
	.

crossOverSubset(_, [], _, _):-true.

crossOverSubset(_, _, 0, _):-true.

crossOverSubset(ProductsSubset, Products, Size, OutputFile):-
	Size > 0,
	sublist(ProductsSubset, Products),
	length(ProductsSubset, Size).
	appendToFile(OutputFile, ProductsSubset).

crossOverSubset(ProductsSubset, Products, Size, OutputFile):-
	Size>1,
	crossOverSubset(ProductsSubset, Products, Size-1, OutputFile).

notAlreadyMapped((E1,R1),[(E2,_)|L]):-
	E1\==E2,
	notAlreadyMapped((E1,R1),L)
	.

notAlreadyMapped((_,_),[]):-true.

checkSolution(Sol):-
	Sol=[(E,R)|PotentialSolution],
	notAlreadyMapped((E,R),PotentialSolution),
	checkImplications(PotentialSolution),
	checkSolution(PotentialSolution).

checkSolution([_]):-true.

computeAllAffectations(Solutions, Elements, Rules):-
	length(Elements, NbOfElements),
	findall((Element,Rule), canApply(Element, Rule), AllAffectionPairs),
	findall(Solution,
		(
		 sublist(UnsortedSolution, AllAffectionPairs),
		 checkSolution(UnsortedSolution),
		 length(UnsortedSolution,NbOfElements),
		 quick_sort2(UnsortedSolution,Solution)
		),
		Solutions
	       )
	.

computeAffectationsSubset(SolutionsSubset, Solutions, Size, OutputFile):-
	Size>0,
	sublist(SolutionsSubset, Solutions),
	length(SolutionsSubset, Size),
	writeToFile(OutputFile, SolutionsSubset).

computeAffectationsSubset(SolutionsSubset, Solutions, Size, OutputFile):-
	Size>1,
	computeAffectationsSubset(SolutionsSubset, Solutions, Size-1, OutputFile).

computeAffectationsSubset(_, [X], _, OutputFile):-writeToFile(OutputFile, [X]).

computeAffectationsSubset(_, [], _, _):-true.

computeAffectationsSubset(_, _, 0, _):-true.


writeToFile(File, Content):-
	open(File, write, Stream),
	write(Stream, Content),
	nl(Stream),
	close(Stream).

appendToFile(File, Content):-
	open(File, append, Stream),
	write(Stream, Content),
	nl(Stream),
	close(Stream).
