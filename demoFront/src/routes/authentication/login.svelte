<script lang="ts">
	import { Label, Input } from 'flowbite-svelte';
	import { SignIn } from '$lib';

	let title = 'JDE 계정으로 로그인하세요';
	let site = {
		name: 'Wilus',
		img: '/images/wilus-logo.png',
		link: '/',
		imgAlt: 'FlowBite Logo'
	};
	let rememberMe = true;
	let lostPassword = true;
	let createAccount = true;
	let lostPasswordLink = 'forgot-password';
	let loginTitle = '로그인';
	let registerLink = 'sign-up';
	let createAccountTitle = 'Create account';

	const onSubmit = (e: Event) => {
		const formData = new FormData(e.target as HTMLFormElement);

		const data: Record<string, string | File> = {};
		for (const field of formData.entries()) {
			const [key, value] = field;
			data[key] = value;
		}
		console.log(data);
	};
</script>

<SignIn
	{title}
	{site}
	{rememberMe}
	{lostPassword}
	{createAccount}
	{lostPasswordLink}
	{loginTitle}
	{registerLink}
	{createAccountTitle}
	on:submit={onSubmit}
>
	<div>
		<Label for="email" class="mb-2">JDE 계정</Label>
		<Input type="email" name="email" id="email" placeholder="name@company.com" required />
	</div>
	<div>
		<Label for="password" class="mb-2">JDE 패스워드</Label>
		<Input type="password" name="password" id="password" placeholder="••••••••" required />
	</div>
</SignIn>
