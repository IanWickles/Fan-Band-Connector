<!--blanket nav to home|search|login/logout-->

<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link> |
      <router-link v-bind:to="{ name: 'bands' }">Bands</router-link> |
      <router-link v-bind:to="{ name: 'venues' }">Venues</router-link> |
      <router-link v-bind:to="{ name: 'profile' }">Profile</router-link>
      |
      <router-link
        v-bind:to="{ name: 'login' }"
        v-if="($store.state.token = 'token')"
        >Login</router-link
      >
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != 'token'"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>
<style></style>
