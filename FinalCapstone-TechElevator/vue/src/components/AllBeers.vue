<template>
    <div>
      <h2> Beers</h2>
      <button class="btn" v-on:click="retrieveAllBeers">Get Beers</button>
       <div id="appoint_grid"
        class="card"
        v-for="item in allBeers"
        v-bind:key="item.beerId"
        >
        <div class="header">
          <h3>{{ item.beerName }}</h3>
        </div>
        <div id="detail" class="footer">
          <span class="detail">{{ item.beerDescription  }}</span>
          <span class="detail">{{ item.beerPrice }}</span>
           <span class="detail">{{ item.beerType }}</span>
        </div>
      </div>
    </div>
</template>

<script>
import boardsService from "../services/AuthService";
export default {
  name: "all-beer",
  components: {
    //BoardColumn
  },
  props: {
    boardId: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      allBeers : [],
      isLoading: true,
      errorMsg: ""
    };
  },
  methods: {
    retrieveAllBeers() {
      boardsService
        .getAllBeers()
        .then(response => {
          this.allBeers = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Board cards not available. This board may have been deleted or you have entered an invalid board ID."
            );
            this.$router.push({ name: 'Home' });
          }
        });
    },
  },
};
</script>
<style scope>
  .btn {
    width: 200px;
    font-size: 18px;
    border-radius: 5px;
    border: 1px solid white;
    background-color: rgb(23, 107, 218);
    padding: 11px 20px 11px 20px;
  }
</style>
