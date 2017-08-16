#!/usr/bin/env python

import sys

for line in sys.stdin:
	splits = line.strip().split(',')
	if len(splits) != 4:
		continue
	event_id = splits[1]
	print event_id + '\\' + '1'

