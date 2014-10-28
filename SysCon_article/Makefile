EPSFILES=${wildcard figures/*.eps *.tex}
SECTIONS=${wildcard sections/*.tex}

BASE=article_syscon
BIBFILES=$(BASE).bib
TEXFILES=$(BASE).tex ${SECTIONS}

all: $(BASE).pdf

mac: all $(BASE).pdf $(BASE).tex
	open $(BASE).pdf

wc: $(BASE).pdf
	pdftotext $(BASE).pdf
	wc $(BASE).txt

edit:
	texmaker -master $(BASE).tex 2> /dev/null &

$(BASE).ps: $(BASE).dvi
	dvips -o $(BASE).ps $(BASE).dvi

$(BASE).dvi: $(TEXFILES) $(EPSFILES) $(BIBFILES)
	-pdflatex $(BASE).tex
	-bibtex $(BASE)
	-pdflatex $(BASE).tex
	-pdflatex $(BASE).tex

# After the last run of $(LATEX), we ensure there is no duplicated
# labels, missing references or citations.


DUP_LABEL = grep 'LaTeX Warning: Label'
UNDEF_REF = grep 'LaTeX Warning: Reference'
UNDEF_CIT = grep 'LaTeX Warning: Citation'

check:
	@$(DUP_LABEL) $(BASE).log && exit 1 || echo "Labels     are fine"
	@$(UNDEF_REF) $(BASE).log && exit 1 || echo "References are fine"
	@$(UNDEF_CIT) $(BASE).log && exit 1 || echo "Citations  are fine"

$(BASE).pdf: $(TEXFILES) $(BASE).bib
	-pdflatex $(BASE).tex
	-bibtex $(BASE)
	-pdflatex $(BASE).tex
	-pdflatex $(BASE).tex	

clean:
	rm -r -f *.aux *.log $(SOURCES)
	rm -r -f $(BASE).dvi $(BASE).ps *.brf
	rm -r -f *.bbl *.blg *~ *.bak *.backup *.cb *.cb2 *.lol *.toc *.lof *.out

veryclean: clean
	rm -f $(BASE).pdf

