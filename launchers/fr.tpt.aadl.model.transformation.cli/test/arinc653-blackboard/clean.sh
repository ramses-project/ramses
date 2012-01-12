#!/bin/bash

find .. -name "*.map" -print0 | xargs -r -0 rm
find .. -name "*.o" -print0 | xargs -r -0 rm
find .. -name "*.lo" -print0 | xargs -r -0 rm
