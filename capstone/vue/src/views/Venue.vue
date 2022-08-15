<template>
  <venue-details v-bind:venueId="parseInt($route.params.venueId)"/>
</template>
<!--
//uses venueDetails
-->
<script>
import VenueDetails from "../components/VenueDetails.vue";
export default {
  components: { VenueDetails },
};
</script>

<style></style>
