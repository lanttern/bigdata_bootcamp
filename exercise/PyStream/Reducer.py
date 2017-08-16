import sys

curr_event = None
curr_count = 0
event_name = None
for line in sys.stdin:
	event_name, count = line.strip().split('\t')[0], 1
	try:
		count = int(count)
	except ValueError:
		continue
	if curr_event == event_name:
		curr_count += count
	else:
		if curr_event: print '%s\t%d'%(curr_event, curr_count)
		curr_event = event_name
		curr_count = count
if curr_event == event_name:
	print '%s\t%d'%(curr_event, curr_count)

