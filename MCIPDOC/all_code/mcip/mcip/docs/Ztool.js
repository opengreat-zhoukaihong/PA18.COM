
////////////////////////////////////////////////////////
// Author£ºZhulx
// Function£ºFor js tool
// Create date£º2000/10/18
// Update date£º2000/11/13
////////////////////////////////////////////////////////

function radioDisable(Index,field)
{	//for text disable
   if(Index == "t")
   {
      	field.disabled = true;
   }	
   else if(Index == "f")
   {
      	field.disabled = false;
   }
   return;
}

function editCityName(fieldProv,fieldCity)
{//for text=value
   if(fieldProv.value == "")	
      return;
 index = fieldProv.options.selectedIndex;
 fieldCity.length = city[index].length;
 for(var i = 0;i<city[index].length;i++)
  {
   var text = city[index][i].split("-");
   fieldCity.options[i].text = text[0];
   fieldCity.options[i].value =text[0];//text=value
  }
  
  return;
}

