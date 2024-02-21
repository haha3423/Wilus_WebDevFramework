<script lang="ts">
	import { Input, Label, Select, Helper, type InputType, Card, Heading, Button } from 'flowbite-svelte';
	import { createEventDispatcher } from 'svelte';

	export let formName: string;
	export let formData: {
		objTyp: string,
		label: string;
		type: InputType;
		id: string;
		placeholder: string;
		value: any;
		items: []
	}[];

	const dispatch = createEventDispatcher();

	function changeInput(event) {
		updateValue(event.target.id, event.target.value)
		dispatch('formDataChange', formData);
	}

	function updateValue(id: string, value: any) {
		for (let i = 0; i < formData.length; i++) {
			if (formData[i].id === id) {
				formData[i].value = value;
				break; // id가 'cho'인 요소를 찾았으므로 더 이상 반복할 필요가 없음
			}
		}
	}

</script>

<Card size="xl">
	<Heading tag="h3" class="mb-4 text-xl font-medium tracking-wide dark:text-white"
	>{formName}
	</Heading>
	<form class="grid grid-cols-6 gap-6">
		{#each formData as { objTyp, label, id, type, placeholder, value, items }}
			{#if objTyp === 'input'}
				<Label class="space-y-2 col-span-2 sm:col-span-2">
					<span>{label}</span>
					<Input class="font-normal" {id} {type} {placeholder} {value} on:change={changeInput} />
				</Label>
			{/if}
			{#if objTyp === 'select'}
				<Label class="space-y-2 col-span-2 sm:col-span-2">
					<span>{label}</span>
					<Select {id} class="font-normal" {items} />
				</Label>
			{/if}
		{/each}
		<Button size="sm" outline>조회</Button>
	</form>
</Card>
