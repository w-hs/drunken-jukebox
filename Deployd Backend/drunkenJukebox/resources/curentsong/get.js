//Playlist ersten entry entnehmen
//Playlist wieder auffüllen
//

var votes = -999999;
var songID = null;
dpd.playlist.get(function (result, err) {
  if(err) return console.log(err);
  //sortieren und ersten Entry zurück geben
 
  
  for(var i = 0; i< result.length; i++)
  {
       
    if(result[i].votes >= votes)
     {
         votes  = result[i].votes;
        songID = result[i].songID;
     }
  }
  
  this.songID = songID;
});


