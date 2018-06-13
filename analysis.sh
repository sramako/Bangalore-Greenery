#!/bin/bash
python menu.py
python analysis.py 1
python menu.py
python analysis.py 2
python compare.py >Analysis/analysis.txt
cat Analysis/analysis.txt
