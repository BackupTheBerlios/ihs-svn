BASE=..
LANGS=pl en

.PHONY: all all-doc clean subdirs

all-doc: doc-html 
#doc-rtf

include $(BASE)/Makefile.common

doc-html:
	for l in $(LANGS) ; do \
		./insert_code.pl $$l.src .xml ; \
		(cd $$l.html/ && env SGML_CATALOG_FILES=$(JADE_CATALOG) \
		openjade -t sgml -i output-html -d ../$$l.src/stylesheet.dsl \
		$(JADE_XML_DCL) \
		../$$l.src/index.xml ) || exit 1 ; \
		cp -f $$l.src/stylesheet.css $$l.html ; \
		(cd $$l.html && ../mime-type.sh) || exit 1; \
	done
	(cd desspec/ && env SGML_CATALOG_FILES=$(JADE_CATALOG) \
	openjade -t sgml -i output-html -d ../en.src/stylesheet.dsl \
	$(JADE_XML_DCL) \
	desspec.xml ) || exit 1 ;
	(cd desspec && ../mime-type.sh) || exit 1;

doc-rtf:
	for l in $(LANGS) ; do \
		./insert_code.pl $$l.src .xml ; \
		(cd $$l.rtf/ && env SP_ENCODING=ISO-8859-2 \
		SGML_CATALOG_FILES=$(JADE_CATALOG) \
		openjade -t rtf -i output-print -d ../$$l.src/stylesheet.dsl \
		$(JADE_XML_DCL) \
		../$$l.src/index.xml ) || exit 1 ; \
		mv $$l.src/index.rtf $$l.rtf/ ; \
	done

all: 

clean:
	for l in $(LANGS) ; do \
		rm -rf $$l.html/* ; \
	done

mirrors-put:
	find *.html/ -type f -exec chmod a+r {} \; -o -type d -exec chmod a+rx {} \;
	rsync -vCr --delete --rsh "ssh -l rsync" *.html foo-baz.com::foo-baz.com/www/foo-baz.com/ihs/
	for l in $(LANGS) ; do \
		rsync -vCr --delete --rsh "ssh -l paweln" $$l.html/ shell.sourceforge.net:/home/groups/i/ih/ihs/htdocs/$$l.html ; \
	done
