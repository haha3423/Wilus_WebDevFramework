<svelte:head>
	<script src="https://unpkg.com/ag-grid-community/dist/ag-grid-community.min.noStyle.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/ag-grid-community@31.0.3/styles/ag-grid.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/ag-grid-community@31.0.3/styles/ag-theme-alpine.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/ag-grid-community@31.0.3/styles/ag-theme-balham.css" />
</svelte:head>
<script>
	// @ts-nocheck
	import { Card, Heading } from 'flowbite-svelte';
	import { onMount } from 'svelte';
	import { createGrid } from 'ag-grid-community';

	// Parameters
	export let gridName;
	export let gridOptions;

	// console.log('grid:gridOptions', gridOptions);
	
	let gridApi, gridContainer, initialize;
	
	onMount(() => {
		// agGrid Init
		gridApi = createGrid(gridContainer, gridOptions);
		initialize = true
		// console.log('api', api);
	});
	
	$:if (initialize && gridOptions) {
		//console.log('그리드옵션 변경됨')
		gridApi.updateGridOptions(gridOptions)
	}
	
</script>

<Card size="xl">
	<Heading tag="h3" class="mb-4 text-xl font-medium tracking-wide dark:text-white"
	>{gridName}
	</Heading>
	<div id="datagrid" class="ag-theme-balham" style="height: 600px; width: auto;" bind:this={ gridContainer }></div>

</Card>
