<template>
  <div>
    <div
      id="appoint_grid"
      class="cards"
      v-for="item in allBreweries"
      v-bind:key="item.breweryID"
    >
      <div id="cssEdits" class="box">
        <h1 id="breweryName" class="breweryName">{{ item.breweryName }}</h1>
        <div class="detail" id="breweryDescription">{{ item.breweryDescription }}</div>
        <div class="detail" id="streetName">{{ item.streetName }},{{ item.zipCode }}</div>
        <div class="detail" id="phoneNumber">{{ item.phoneNumber }}</div>
        <div class="detail" id="websiteUrl">{{ item.websiteUrl }}</div>
      </div>
    </div>
  </div>
</template>
<script>
import boardsService from "../services/AuthService";
export default {
  name: "all-breweries",
  components: {
    //BoardColumn
  },
  props: {
    boardId: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      allBreweries: [],
      isLoading: true,
      errorMsg: "",
    };
  },
  methods: {
    retrieveAllBreweries() {
      boardsService
        .getAllBreweries()
        .then((response) => {
          this.allBreweries = response.data;
          this.isLoading = false;
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert(
              "Board cards not available. This board may have been deleted or you have entered an invalid board ID."
            );
            this.$router.push({ name: "Home" });
          }
        });
    },
  },
};
</script>
<style scoped>
#cssEdits {
  padding: 100px;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(4, 1fr);
  grid-column-gap: 10px;
  grid-row-gap: 25px;
  border-style: solid;
  border-color: black;
}
#breweryName {
  grid-area: 1 / 1 / 2 / 6;
  text-align: center;
  font-size: 50px;
}
#address {
  grid-area: 2 / 4 / 4 / 6;
  font-size: 30px;
}
#breweryDescription {
  grid-area: 2 / 1 / 4 / 4;
  font-size: 30px;
}
#phoneNumber {
  grid-area: 4 / 1 / 5 / 3;
  font-size: 30px;
}
#websiteUrl {
  grid-area: 4 / 4 / 5 / 6;
  font-size: 30px;
}
</style>
