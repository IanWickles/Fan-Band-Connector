<template>
  <div class="band-container">
    <band
      v-bind:band="band"
      v-for="band in $store.state.bands"
      v-bind:key="band.id"
    />
  </div>
</template>

<script>
import Band from "@/components/Band.vue";

export default {
  name: "band-list",
  components: { Band },
};
</script>

<style></style>
