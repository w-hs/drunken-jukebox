//playlist füllen

    this.start = new Date();
    this.end = {};
    this.avgDI = 0;
    this.guestCount = 1;


dpd.playlist.get(function (result, err) {
    

    for(var i = 0; i< result.length; i++)
      {
           
           dpd.playlist.del(result[i].id,function(result, error) {});
      }
});

dpd.songs.get(function (result, err) {
  if(err) return console.log(err);

    

    for(var i = 0; i<10;i++)
    {
     
      
        dpd.playlist.post({songID: result[i].id ,position:0,votes:0}, function(result, error) {
     
         
         });
        
    }


  
});


