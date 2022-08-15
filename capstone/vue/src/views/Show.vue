<template>
  <show-details v-bind:showId="parseInt($route.params.showId)"/>
</template>
<!--
//uses showDetails
-->
<script>
import ShowDetails from "../components/ShowDetails.vue";
export default {
  components: { ShowDetails },
};
</script>

<style></style>