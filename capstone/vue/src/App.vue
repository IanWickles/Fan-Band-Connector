<!--blanket nav to home|search|login/logout-->

<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link> |
      <router-link v-bind:to="{ name: 'search' }">Search</router-link> |
      <router-link
        v-if="$store.state.token != null"
        v-bind:to="{ name: 'login' }"
        >Login</router-link
      >
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>
<style></style>
