# CodewarsChallenge
Codewars Challenge it's an application developed by Richard Anemam based on Codewars API. You can find the documentation over here: https://dev.codewars.com/#introduction. The app follows the MVVM architecture and makes use of retrofit for API requests, dagger2 for dependency injection, livedata to evaluate states and viewbinding to bind views to data sources in a declarative way. Apart from that, the application is built in Kotlin and makes use of Mockk for unit testing. Also, there are a few UI tests that utilizes Espresso and employs the Robot Pattern. 

The app allows you to search for a Codewars member by its username and list it in a Recyclerview that displays the last 5 recent searches. This list can re-ordered by rank once clicking on <b>ORDER BY RANK</b> menu button. Also, this list is being cached with Room database. Here's a link of the current leaderboard to get you started with the username search: https://www.codewars.com/users/leaderboard. On clicking <b>show challenges</b> it'll display details about complete and authored challenges.

This is a <i>working in progress</i> project, I'm always improving and learning from it. As it follows I'm on my way to improve test coverage and the repository pattern with the cache policy. The future holds feature modularization... Take a look at the source code and, if you have any questions or suggestions, feel free to hit me up. Happy coding :)


