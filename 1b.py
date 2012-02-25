#!/usr/bin

import math

def is_prime(x):
	sqrt = int(math.sqrt(x)+1)
	for i in range(2,sqrt):
			if x % i == 0: 
				return 1
	
T = int(input())
for t in range(1,T+1):
	count = 0
	N = int(input())
	for i in range(1,N+1):
		if i >1:
			if  not is_prime(i) and not is_prime(2*i + 1):
				count = count+1
	print "Case #%d: %d" % (t, count)
