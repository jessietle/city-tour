<template>
    <b-card 
        img-src="https://www.trolleytours.com/wp-content/uploads/2016/06/washington-dc-winter.jpg"
        img-alt="Image"
        img-top
    >
        <template #header>
        <h4 class="mb-0">{{ itinerary.name }}</h4>
        </template>

        <b-card-body>
            <b-card-title>{{ getDate() }}</b-card-title>
        </b-card-body>

        <b-list-group flush>
            <b-list-group-item 
                v-for="attraction in getAttractionsName()" 
                v-bind:key="attraction.id"
            >
                {{ attraction }}
            </b-list-group-item>
        </b-list-group>

        <!-- Display "this object is empty" message if attractions array is empty -->
        <b-card-body v-if="getAttractionsName().length === 0">
            This itinary is empty. Please add attractions you want to visit !!! (^,...,^)
        </b-card-body>

        <b-card-body v-if="getAttractionsName().length !== 0">
            <router-link 
                v-bind:to="{ 
                    name: 'itineraryDetail', 
                    params: { itineraryId: this.itinerary.id } 
                    }" 
            >
                View Details
            </router-link>
        </b-card-body>
        <b-card-body>
            <b-button variant="danger" @click="handleRemove">Remove</b-button>
        </b-card-body>

    </b-card>
</template>

<script>
import service from '../services/ServerService'

export default {
    props: ['itinerary'],
    methods: {
        getDate() {
            return this.itinerary.date.substring(0,10);
        },
        getAttractionsName() {
            return this.itinerary.locations.map(x => x.name);
        },
        handleRemove() {
            service
                .deleteItinerary(this.itinerary.id)
                .then(res => {
                    if (res.status === 200) {
                        window.location.reload();
                    }
                })
                .catch(error => {
                    if (error.response) {
                        window.alert("Bad Request");
                    } else if (error.request) {
                        window.alert("Could not reach service");
                    }
                });
        }
    }
}
</script>