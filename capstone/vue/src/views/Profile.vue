<template>
  <div>
    <user-details v-bind:userId="parseInt($route.params.userId)" />
    <!-- if user is manager of a band, have this link to the band they manage, hide button if not a manager -->
    <h1 class="user-inbox">Inbox</h1>
    <div class="inbox-content">
      <message-list />
    </div>

    <br />
  </div>
</template>
<!--
//uses userDetails component
//profile info --&picture? 
//need to have a message section -- date descending
// sort button, by band/date
-->
<script>
import MessageList from "../components/MessageList.vue";
import UserDetails from "../components/UserDetails.vue";
export default {
  components: { UserDetails, MessageList },
};
</script>
<style>
.inbox-content {
  text-align: left;
}
#manager {
  text-align: center;
}
</style>
