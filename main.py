import sys
import numpy as np
from PIL import Image
im = Image.open(sys.argv[1])
pix = im.size
file=open("Download/part-00000","r")
a=file.readline()[6:]
b=file.readline()[6:]
a = int(a)
b = int(b)
total=pix[0]*pix[1]
green = (a+0.0) / (total-b) * 100
print(green)
