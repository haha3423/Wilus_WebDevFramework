<script>
	import AppsMenu from '$lib/widgets/AppsMenu.svelte';
	import UserMenu from '$lib/widgets/UserMenu.svelte';
	// @ts-ignore
	import { DarkMode, NavBrand, NavHamburger, Navbar, Search, ToolbarButton } from 'flowbite-svelte';
	// import { BellSolid } from 'flowbite-svelte-icons';
	import '../../app.postcss';
	import Users from '../data/users.json';

</script>

<Navbar fluid color="default">
	<div class="flex items-center justify-start w-fit">
		<NavHamburger />
		<NavBrand href="/" class="ms-2 md:me-24">
			<img
				src= "/images/wilus-logo.png"
				class="me-3 h-6 sm:h-8"
				alt="Flowbite Logo"
			/>
			<span class="self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white">Wilus</span>
		</NavBrand>
		<div class="w-96">
			<Search size="md" />
		</div>
	</div>

	<div class="flex items-center ms-auto gap-2 p-1">
		<!-- <ToolbarButton size="lg"><BellSolid /></ToolbarButton> -->
		<AppsMenu />
		<DarkMode />
		<!-- 더미 유저 데이터 사용 -->
		<UserMenu {...Users[4]} />
	</div>
</Navbar>
