TOP_DIR = ../..
include $(TOP_DIR)/tools/Makefile.common
KB_RUNTIME ?= /kb/runtime
KB_TOP ?= /kb/deployment
JAVA_HOME ?= $(KB_RUNTIME)/java
TARGET ?= $(KB_TOP)
MAIN_CLASS = us.kbase.kbaseenigmametals.DataMatrixUploader
DEPLOY_JAR = $(KB_TOP)/lib/jars/kbase/enigma-metals

default: compile

deploy: deploy-lib

deploy-lib: 
	rm -rf $(DEPLOY_JAR)
	mkdir -p $(DEPLOY_JAR)
	cp ./dist/kbase-enigma-metals-0.1.jar $(DEPLOY_JAR)

build-lib:
	./make_jar.sh $(MAIN_CLASS)

compile: build-lib

test: test-scripts

test-scripts:
	@echo "Nothing to test"

clean:
	@echo "nothing to clean"

