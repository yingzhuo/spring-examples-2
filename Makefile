timestamp := $(shell /bin/date "+%F %T")

no_default:
	@echo "no default target"

clean:
	@mvn -f $(CURDIR)/pom.xml clean -q

github: clean
	@git add .
	@git commit -m "$(timestamp)"
	@git push

.PHONY: no_default clean github
