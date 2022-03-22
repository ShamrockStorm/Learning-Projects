function Generation_To_Consoles(value){
	switch(value){
		case '1':
			document.getElementById("Gen1D").style.display = "inline";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
			
		break;
		case '2':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "inline";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '3':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "inline";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '4':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "inline";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '5':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "inline";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '6':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "inline";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '7':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "inline";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '8':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "inline";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '9':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "inline";
			document.getElementById("Gen0D").style.display = "none";
		break;
		case '0':
			document.getElementById("Gen1D").style.display = "none";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "inline";
		break;
		default:
			document.getElementById("Gen1D").style.display = "inline";
			document.getElementById("Gen2D").style.display = "none";
			document.getElementById("Gen3D").style.display = "none";
			document.getElementById("Gen4D").style.display = "none";
			document.getElementById("Gen5D").style.display = "none";
			document.getElementById("Gen6D").style.display = "none";
			document.getElementById("Gen7D").style.display = "none";
			document.getElementById("Gen8D").style.display = "none";
			document.getElementById("Gen9D").style.display = "none";
			document.getElementById("Gen0D").style.display = "none";
	}
}
function LoadComments(){
	//Comments = '[{"UserName":"Daniel Blaga"},{"UserName":"SomethigSomething"}]';
	Generation_To_Consoles('1');
	const obj = JSON.parse(Comments);
	//alert(obj[0].UserName);
	
	for(var Com in obj)
	{
		if (obj.hasOwnProperty(Com)) {
		var tag = document.createElement("div");
		var bre = document.createElement("br");
	
		var p1 = document.createElement("p");
		var textp1 = document.createTextNode("UserName: "+obj[Com].UserName);
		var p2 = document.createElement("p");
		var textp2 = document.createTextNode("Platforms: "+obj[Com].Platforms);
		var p3 = document.createElement("p");
		var textp3 = document.createTextNode("Comment: "+obj[Com].Comm);
	
		p1.appendChild(textp1);
		p2.appendChild(textp2);
		p3.appendChild(textp3);
	
		tag.appendChild(p1);
		tag.appendChild(p2);
		tag.appendChild(p3);
	
		var element = document.getElementById("CommentCase");
		tag.classList.add("comment");
		element.appendChild(tag);
		}
	}
	element.appendChild(bre);
	
}

function SubmitComment(){
	var UN = document.getElementById("tName").value;
	
	var PI = "";
	if(document.getElementById("cMO").checked == true) PI=PI+"Magnavox Odyssey, ";
	if(document.getElementById("cA2600").checked == true) PI=PI+"Atari 2600, ";
	if(document.getElementById("cMO2").checked == true) PI=PI+"Magnavox Odyssey 2, ";
	if(document.getElementById("cGW").checked == true) PI=PI+"Game & Watch, ";
	if(document.getElementById("cA5200").checked == true) PI=PI+"Atari 5200, ";
	
	if(document.getElementById("cNES").checked == true) PI=PI+"Nintendo Entertainment System, ";
	if(document.getElementById("cSG1000").checked == true) PI=PI+"Sega SG-1000, ";
	if(document.getElementById("cSMS").checked == true) PI=PI+"Sega Master System, ";
	if(document.getElementById("cFDS").checked == true) PI=PI+"Famicom Disk System, ";
	if(document.getElementById("cA7800").checked == true) PI=PI+"Atari 7800, ";
	
	if(document.getElementById("cPCE").checked == true) PI=PI+"PC Engine/ Turbografx 16, ";
	if(document.getElementById("cSG").checked == true) PI=PI+"Sega genesis/ Mega Drive, ";
	if(document.getElementById("cGB").checked == true) PI=PI+"GameBoy, ";
	if(document.getElementById("cALX").checked == true) PI=PI+"Atari Lynx, ";
	if(document.getElementById("cSNES").checked == true) PI=PI+"Super Nintendo, ";
	if(document.getElementById("cSGG").checked == true) PI=PI+"Sega GameGear, ";
	
	if(document.getElementById("cPS1").checked == true) PI=PI+"PlayStation, ";
	if(document.getElementById("cN64").checked == true) PI=PI+"Nintendo 64, ";
	if(document.getElementById("cBW").checked == true) PI=PI+"Bandai Wanderswan, "
	
	if(document.getElementById("cSDr").checked == true) PI=PI+"Sega Dreamcast, ";
	if(document.getElementById("cPS2").checked == true) PI=PI+"PlayStation2, ";
	if(document.getElementById("cGCN").checked == true) PI=PI+"GameCube, ";
	if(document.getElementById("cX").checked == true) PI=PI+"XBox, ";
	if(document.getElementById("cGBA").checked == true) PI=PI+"GameBoyAdvance, ";
	if(document.getElementById("cPCS").checked == true) PI=PI+"steam, ";
	if(document.getElementById("cNDS").checked == true) PI=PI+"Nintendo DS, ";
	if(document.getElementById("cPSP").checked == true) PI=PI+"PlayStation Portable, ";
	
	if(document.getElementById("cX360").checked == true) PI=PI+"XBox360, ";
	if(document.getElementById("cPS3").checked == true) PI=PI+"Playstation 3, ";
	if(document.getElementById("cWii").checked == true) PI=PI+"Nintendo Wii, ";
	
	if(document.getElementById("c3DS").checked == true) PI=PI+"nintendo 3DS, ";
	if(document.getElementById("cPSV").checked == true) PI=PI+"PlayStation Vita, ";
	if(document.getElementById("cWiiU").checked == true) PI=PI+"nintendo WiiU, ";
	if(document.getElementById("cPS4").checked == true) PI=PI+"Playstation 4, ";
	if(document.getElementById("cXOne").checked == true) PI=PI+"XBox One, ";
	if(document.getElementById("cNS").checked == true) PI=PI+"Nintendo Switch, ";
	
	if(document.getElementById("cXS").checked == true) PI=PI+"XBox Series S/X, ";
	if(document.getElementById("cPS5").checked == true) PI=PI+"PlayStation 5, "
	
	PI=PI+ document.getElementById("cOther").value;
	
	var C = document.getElementById("tCom").value;
	
	obj[Com].push({UserName: UN, Platforms: PI, Comm: C});
	
	
	
	//Didn't have time to learn NodeJS, had to cut my loses and keep it in this state as a proof of concept
	//alert(C+"!");
}