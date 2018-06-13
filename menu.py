import os
place =["banashankari","cubbonpark","adugodi","agaram","agrahara_dasarahalli","amruthahalli","anjanapura","attiguppe","bagalakunte","banasavadi","banashankari","bangalore_university","basavanagudi","cubbonpark","cubbonpark1","domlur","gandhinagar","hebbala","hsr_layout","jayanagar_5th_block","jp_nagar,katriguppe","marathahalli","narayanapura","rajaji_nagar","ulsoor","uttarahali","yediyur","yelahanka","yeshwanthpur"]
for i in range(0,len(place)):
	print i,":",place[i]
inp=input('Enter location : ')

os.system("python pixel.py "+place[inp]+" > Input/out.txt")
os.system("./split.sh "+place[inp]+".jpg")
os.system("./test.sh")
#os.system("ls")
os.system("python main.py "+place[inp]+".jpg >Output/out.txt")
