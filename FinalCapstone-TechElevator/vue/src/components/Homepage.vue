
<template>
<div id="body">
<div id="container">
  <div class="boxes">
  <ul>
    <li>Local Brewery</li>
    <li>Texas Brewery</li>
    <li>Old Town Brewery </li>
     <li>Down Town Brewery</li>
     <li>Hot Town Brewery</li>
  </ul>
  </div>
  <p>A new Irish Craft Beer Brewery looking to bring some old school and new brews to the market.
  </p>
  </div>
  </div>

</template>

<script>

</script>

<style scoped>
p {
  width:100%;
  padding: 20px;
  font-size: 50px;
  text-align: center;
  color:white;
  font-weight: bolder;
  /* background-color: beige; */
}
ul{
  border:1px solid red;
  text-align: center;
  list-style-type: none;
  color:rgb(17, 56, 231);
  font-size: 25px;
  font-weight:bold;
  /* background-color:green; */
}
#body{
  background-image: url("https://breweryfinder.org/wp-content/uploads/2016/10/BreweryFinder.org_Splash_Header_web.jpg");
  width: 100%;
  height: 100vh;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
h1{
  color: yellow;
  font-size: 55px;
  /* border:1px solid red; */
  background-color:grey;
 

}
#id{
  color: white;
}


#nav{
    /* display:flex; */
 display:flex;
 flex-direction: column;
 justify-content: flex-end;
}


</style>


