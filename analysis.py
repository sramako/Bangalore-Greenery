import sys
file=open("Output/out.txt","r")
a=file.readline()
file2=open("Analysis/"+sys.argv[1]+".txt","w")
file2.write(a)
