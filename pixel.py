import sys
import numpy as np
from PIL import Image
im = Image.open(sys.argv[1]+'.jpg')
pix = im.size
#print pix
pixels = list(im.getdata())
l=len(pixels)
for i in range (0,l):
	print pixels[i][0]," ",pixels[i][1]," ",pixels[i][2]
