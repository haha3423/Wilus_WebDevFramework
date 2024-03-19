<script>
	// @ts-nocheck
	import {
		Breadcrumb, BreadcrumbItem, Button, Card, Heading, Input, Label, Select
	} from 'flowbite-svelte';
	import {onMount} from 'svelte';
	import AgGrid from '$lib/grid/AgGrid.svelte';

	function changeInput(event) {
		const id = event.target.id;
		const value = event.target.value;
		console.log(id, value);
		for (let i = 0; i < formData.length; i++) {
			if (formData[i].id === id) {
				formData[i].value = value;
				break;
			}
		}
	}
	
	// Grid Info
	// 실제 그리드로 전달되는 옵션
	let columnDefs;
	let gridOptions = {
		columnDefs: columnDefs,
		defaultColDef: {
			width: 100,
			editable: true,
			filter: 'agTextColumnFilter'
		},
		defaultColGroupDef: {
			marryChildren: true
		},
		headerHeight: 30,
		floatingFiltersHeight: 30,
		columnTypes: {
			nonEditableColumn: {editable: false},
			dateColumn: {
				filter: 'agDateColumnFilter',
				suppressMenu: true
			}
		},
		rowData: [],
		autoSizeStrategy: {
			type: 'fitCellContents'
		},
		localeText: {noRowsToShow: '조회 결과가 없습니다.'},
		rowHeight: 30
	};
	
	function updateGridOptions(newData) {
		let newColumnDefs
		console.log('newData', newData.length);
		if (newData.length > 0) {
			// ----
			const dataKeys = Object.keys(newData[0]);
			newColumnDefs = dataKeys.map((key) => {
				return {
					field: key,
					headerName: key.charAt(0).toUpperCase() + key.slice(1), // 첫 글자 대문자로 변환하여 사용
					editable: false,
					// filter: 'agTextColumnFilter',
					floatingFilter: true,
					sortable: true,
					autoSize: true
				};
			});
			// ----
		} else {
			newColumnDefs = columnDefs
		}
		gridOptions = {...gridOptions, columnDefs: newColumnDefs, rowData: newData};
	}

		const menuName = "UIP TEST";
		const formName = 'Form Name';
		let formData = [{"idx":0,"objTyp":"input","label":"var1","id":"var1","type":"text"},{"idx":1,"objTyp":"input","label":"var2","id":"var2","type":"text"},{"idx":2,"objTyp":"input","label":"var3","id":"var3","type":"text"},{"idx":3,"objTyp":"select","label":"var4","type":"select","items":[{"name":"전체","value":"전체"}],"id":"var4"},{"idx":4,"objTyp":"input","label":"var5","id":"checkboxitem1","type":"checkbox"},{"idx":5,"objTyp":"input","label":"var6","id":"var6","type":"date"}]
	
		columnDefs = [{"idx":1,"editable":false,"floatingFilter":true,"sortable":true,"autoSize":true,"field":"var7","headerName":"Default","type":"string"},{"idx":2,"editable":false,"floatingFilter":true,"sortable":true,"autoSize":true,"field":"var8","headerName":"Default","type":"string"},{"idx":3,"editable":false,"floatingFilter":true,"sortable":true,"autoSize":true,"field":"var9","headerName":"Default","type":"string"},{"idx":4,"editable":false,"floatingFilter":true,"sortable":true,"autoSize":true,"field":"var10","headerName":"Default","type":"string"},{"idx":5,"editable":false,"floatingFilter":true,"sortable":true,"autoSize":true,"field":"var11","headerName":"Default","type":"string"},{"idx":6,"editable":false,"floatingFilter":true,"sortable":true,"autoSize":true,"field":"var12","headerName":"Default","type":"string"}]
		gridOptions = {...gridOptions, columnDefs: columnDefs, rowData: []};
	
	</script>

	<main class="relative w-full h-full p-4 overflow-y-auto bg-gray-50 dark:bg-gray-900">
		<!-- Breadcrumbs -->
		<Breadcrumb class="mb-5">
			<BreadcrumbItem home>Home</BreadcrumbItem>
			<BreadcrumbItem
					class="inline-flex items-center text-gray-700 hover:text-primary-600 dark:text-gray-300 dark:hover:text-white"
					href="/rental/search">{menuName}</BreadcrumbItem
			>
			<BreadcrumbItem>{formName}</BreadcrumbItem>
		</Breadcrumb>
	
		<Heading tag="h1" class="mb-4 font-semibold tracking-wide text-xl sm:text-2xl">{menuName}</Heading>
	
		<div class="grid grid-cols-1 pt-2 xl:grid-cols-1 xl:gap-4 dark:bg-gray-900">
			<div class="col-span-2 space-y-4">
				<Card size="xl">
					<Heading tag="h3" class="mb-4 text-xl font-medium tracking-wide dark:text-white">{formName}</Heading>
					<form class="grid grid-cols-6 gap-4">
					{#each formData as {objTyp, label, id, type, placeholder, value, items}}
					  {#if objTyp === 'input'}
						<Label class="space-y-2 col-span-1 sm:col-span-1 text-md text-center">
						  <span>{label}</span>
						</Label>
						<Input class="font-normal space-y-2 col-span-1 sm:col-span-1"
						 {id}
						 {type}
						 {placeholder}
						 {value}
						 on:change={changeInput}
						/>
					  {/if}
					  {#if objTyp === 'select'}
						<Label class="space-y-2 col-span-1 sm:col-span-1 text-md text-center">
						  <span>{label}</span>
						</Label>
						<Select {id} class="font-normal space-y-2 col-span-1 sm:col-span-1" {items} on:change={changeInput}/>
					  {/if}
					{/each}
					</form>
					<div class="grid grid-cols-6 gap-6 mt-6 "><Button size="sm" id="button1" outline >초기화</Button><Button size="sm" id="button" outline >조회</Button></div></Card></div></div>
		<div class="grid grid-cols-1 xl:grid-cols-1 xl:gap-4 mt-8">
			<AgGrid gridName="Title" {gridOptions}/>
		</div>
	</main>