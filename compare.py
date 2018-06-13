import sys
import numpy as np
file1=open("Analysis/1.txt","r")
a=file1.read()[0:]
file2=open("Analysis/2.txt","r")
b=file2.read()[0:]
a = float(a)
b = float(b)
l1="Location[1]"
l2="Location[2]"
i=" is"
l3="times greener than "
l4="% green"
print l1+i,a,l4
print l2+i,b,l4
if(a>b):
	r=a/b
	print l1,i,r,l3,l2
else:
	r=b/a
	print l2+i,r,l3,l1
