#!/bin/bash

# Run OFT with verbose output
java -jar openfasttrace.jar trace -v --report-verbosity all --ignore-artifact-types req SimpleRequirement.md SimpleHello.java SimpleHelloTest.java 