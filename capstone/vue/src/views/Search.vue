<template>
  <div>
    <band-list />
    <venue-list />
    <div></div>
  </div>
</template>

<script>
import VenueList from "../components/VenueList.vue";
import BandList from "../components/BandList.vue";
export default {
  components: { VenueList, BandList },
};
</script>

<style></style>
