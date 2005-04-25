BASE=..
LANGS=pl en
JADE?=openjade

.PHONY: all all-doc clean subdirs

all-doc: doc-html 
#doc-rtf

include $(BASE)/Makefile.common

doc-html:
	for l in $(LANGS) ; do \
		./insert_code.pl $$l.src .xml ; \
		(cd $$l.html/ && env SGML_CATALOG_FILES=/usr/local/share/sgml/catalog \
		openjade -t sgml -i output-html -d ../$$l.src/stylesheet.dsl \
		/usr/local/share/sgml/docbook/dsssl/modular/dtds/decls/xml.dcl \
		../$$l.src/index.xml ) || exit 1 ; \
		cp -f $$l.src/stylesheet.css $$l.html ; \
		(cd $$l.html && ../mime-type.sh) || exit 1; \
	done

doc-rtf:
	for l in $(LANGS) ; do \
		./insert_code.pl $$l.src .xml ; \
		cp -f $$l.src/stylesheet.css $$l.rtf ; \
		(cd $$l.rtf/ && env SP_ENCODING=ISO-8859-2 \
		SGML_CATALOG_FILES=/usr/local/share/sgml/catalog \
		openjade -t rtf -i output-print -d ../$$l.src/stylesheet.dsl \
		/usr/local/share/sgml/docbook/dsssl/modular/dtds/decls/xml.dcl \
		../$$l.src/index.xml ) || exit 1 ; \
		mv $$l.src/index.rtf $$l.rtf/ ; \
	done

all: 

clean:
	for l in $(LANGS) ; do \
		rm -rf $$l.html/* ; \
	done
