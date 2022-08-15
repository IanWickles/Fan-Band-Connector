<template>
  <div>
    <h1 class="name">Hello, {{ this.$store.state.user.username }}!</h1>
    </div>
</template>

<script>
import userService from "@/services/UserService.js";

export default {
  name: "user-details",
  props: {
    userId: Number,
  },
  computed: {
    user() {
      return this.$store.state.activeUser;
    },
  },
  methods: {},
  created() {
    userService
      .get(this.userId)
      .then((response) => {
        this.$store.commit("SET_USER", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "not-found" });
        }
      });
  },
};
</script>
<style>

</style>
