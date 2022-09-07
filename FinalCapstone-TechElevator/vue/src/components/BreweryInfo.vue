<template>
    <div>
        <div>{{ brewery.breweryName }}</div>
        <div>{{ brewery.description }}</div>
        <div>Find us at {{ brewery.streetName }} {{ brewery.zipCode }}</div>
        <div>Checkout our own website: {{ brewery.websiteUrl }}</div>
        <div>Or give us a call: {{ brewery.phoneNumber }}</div>

        <!-- <reviews-list class="reviews" v-bind:reviews="brewery.reviews"> -->
    </div>
</template>

<script>
import brewerService from '../services/BrewerService'
//import reviewList from ../components/ReviewList.vue

export default ({
    name: "brewery-info",
    components: {

    },
    data() {
        return {
            brewery: {
                breweryID: '',
                breweryName: '',
                breweryDescription: '',
                streetName: '',
                zipCode: '',
                phoneNumber: '',
                websiteUrl: ''//,
                // reviews: []
            }
        };
    },
    created() {
        brewerService
        .getBrewery(this.$route.params.breweryName)
        .then(response => {
            this.brewery = response;
        });
    }
});
</script>
