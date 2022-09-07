<template>
  <div>
  <button class="homepage">
        <router-link v-bind:to="{ name: 'homepage' }">
          <div class="goHome">Home</div></router-link>
      </button>
      <div class="boxes">
    
    <div class="box">
      <form class="info-form">
        <fieldset>
          <legend>Add Your Brewery</legend>
          <p class="form-para">Input the following information for your brewery.</p>
          <label for="brewery-name">Brewery Name:</label>
          <input
            type="text"
            id="brewery-name"
            name="brewery-name"
            placeholder=" Add Your Brewery Name"
          /><br />
          <label for="brewery-description">Describe Your Brewery:</label>
          <input
            type="text"
            id="brewery-description"
            name="brewery-description"
            placeholder="Add Description"
          /><br />
          <label for="brewery-street-name">Street Address:</label>
          <input
            type="text"
            id="brewery-street-name"
            name="brewery-street-name"
            placeholder="Add Street Address"
          /><br />
          <label for="brewery-zip-code">Zip Code:</label>
          <input
            type="text"
            id="brewery-zip-code"
            name="brewery-zip-code"
            placeholder="Add Zip Code"
          /><br />
          <label for="brewery-phone-number">Phone Number:</label>
          <input
            type="text"
            id="brewery-phone-number"
            name="brewery-phone-number"
            placeholder="Add Phone Number"
          /><br />
          <label for="brewery-url">Brewery's URL:</label>
          <input
            type="text"
            id="brewery-url"
            name="brewery-url"
            placeholder="Add brewery website URL"
          /><br />
          <button id="submit" type="submit" value="Submit" v-on:click="printLine">Submit</button>
        </fieldset>
      </form>
    </div>
    <div class="box">
      <div class="info-form">
        <fieldset>
          <legend>Update Your Brewery</legend>
          <p class="form-para">Only enter the information about your brewery to update.</p>
          <label for="brewery-name">New Brewery Name:</label>
          <input
            type="text"
            id="brewery-name"
            name="brewery-name"
            value="My Brewery"
          /><br />
          <label for="brewery-description">New Description:</label>
          <input
            type="text"
            id="brewery-description"
            name="brewery-description"
            value="Description"
          /><br />
          <label for="brewery-street-name">New Street Address:</label>
          <input
            type="text"
            id="brewery-street-name"
            name="brewery-street-name"
            value="Street Address"
          /><br />
          <label for="brewery-zip-code">New Zip Code:</label>
          <input
            type="text"
            id="brewery-zip-code"
            name="brewery-zip-code"
            value="Zip Code"
          /><br />
          <label for="brewery-phone-number">New Phone Number:</label>
          <input
            type="text"
            id="brewery-phone-number"
            name="brewery-phone-number"
            value="Phone Number"
          /><br />
          <label for="brewery-url">New Brewery URL:</label>
          <input
            type="text"
            id="brewery-url"
            name="brewery-url"
            value="URL"
          /><br />
          <button id="submit" type="submit" value="Submit">Submit</button>
        </fieldset>
      </div>
    </div> 
  </div>
  </div>
</template>
<script>

export default{
  methods: {
    printLine() {
      <p>Form submitted and information added</p>
    }
  }
};
</script>


<style scoped>
.boxes {/**TODO */
  display: flex;
  justify-content: space-between;
}

.box{
  width: 45%;
  margin: 0 auto;
}

.info-form{
  width: 90%;
  margin: 0 auto;

}
fieldset{
  border-radius: 15px;
  height: 750px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
legend{
  text-align: center;
  font-size: 35px;
  font-family: sans-serif;
  color: rgb(110, 65, 65);
  font-family: cursive;
}
.form-para{
  font-size: 20px;
}

label{
  width: 80%;
  font-size: 20px;
  margin-bottom: 8px;
  font-family: cursive;

}
input{
  width: 75%;
  padding: 15px;
  border-radius: 10px;
  border-color: rgb(85, 80, 133);
  font-family: cursive;

}
#submit{
  width: 20%;
  height: 50px;
  font-size: 20px;
  background-color: rgb(9, 179, 247);
  border-radius: 10px;
  border: 1px solid white;
  font-family: cursive;


}


</style>
