<template>
  <div>
    <h1>Shows</h1>
      <show-list />
     </div>
</template>

<script>
import ShowList from "../components/ShowList.vue";
export default {
  components: { ShowList },
};
</script>

<style>
section {
  height: 500px;
  margin: 50px;
}
h1 {
  font-weight: bold;
  margin-bottom: 10px;
}
</style>