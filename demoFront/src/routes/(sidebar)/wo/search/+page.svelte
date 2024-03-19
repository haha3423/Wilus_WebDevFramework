<script>
	// @ts-nocheck
	import {
		Breadcrumb,
		BreadcrumbItem,
		Button,
		Card,
		Heading,
		Input,
		Label,
		Select
	} from 'flowbite-svelte';
	import { onMount } from 'svelte';
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
			nonEditableColumn: { editable: false },
			dateColumn: {
				filter: 'agDateColumnFilter',
				suppressMenu: true
			}
		},
		rowData: [],
		autoSizeStrategy: {
			type: 'fitCellContents'
		},
		localeText: { noRowsToShow: '조회 결과가 없습니다.' },
		rowHeight: 30
	};

	function updateGridOptions(newData) {
		let newColumnDefs;
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
			newColumnDefs = columnDefs;
		}
		gridOptions = { ...gridOptions, columnDefs: newColumnDefs, rowData: newData };
	}

    // ---------------------
	const menuName = 'P4801 - 생산오더조회';
	const formName = '조회조건';
	let formData = [
		{
			idx: 0,
			objTyp: 'input',
			label: 'Ship to Order Number',
			id: 'ShiptoOrderNumber',
			type: 'text'
		},
		{ 
            idx: 1, 
            objTyp: 'input', 
            label: 'Branch/Plant', 
            id: 'BranchPlant', 
            type: 'text' 
        }
	];

	columnDefs = [
		{
			idx: 1,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'orderNo',
			headerName: 'Order No',
			type: 'string'
		},
		{
			idx: 2,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'type',
			headerName: 'Type',
			type: 'string'
		},
		{
			idx: 3,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'itemNo',
			headerName: 'Item No',
			type: 'string'
		},
		{
			idx: 4,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'uom',
			headerName: 'UOM',
			type: 'string'
		},
		{
			idx: 5,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'orderDate',
			headerName: 'Order Date',
			type: 'string'
		},
		{
			idx: 6,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'orderQty',
			headerName: 'Order Qty',
			type: 'string'
		},
		{
			idx: 7,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'status',
			headerName: 'Status',
			type: 'string'
		},
		{
			idx: 8,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'lineID',
			headerName: 'Line ID',
			type: 'string'
		},
		{
			idx: 9,
			editable: false,
			floatingFilter: true,
			sortable: true,
			autoSize: true,
			field: 'customer',
			headerName: 'Customer',
			type: 'string'
		}
	];
	gridOptions = { ...gridOptions, columnDefs: columnDefs, rowData: [] };
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
				<form class="grid grid-cols-4 gap-4">
					{#each formData as { objTyp, label, id, type, placeholder, value, items }}
						{#if objTyp === 'input'}
							<Label class="space-y-2 col-span-1 sm:col-span-1 text-md text-center">
								<span>{label}</span>
							</Label>
							<Input
								class="font-normal space-y-2 col-span-1 sm:col-span-1"
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
							<Select
								{id}
								class="font-normal space-y-2 col-span-1 sm:col-span-1"
								{items}
								on:change={changeInput}
							/>
						{/if}
					{/each}
				</form>
				<div class="grid grid-cols-6 gap-6 mt-6">
					<Button size="sm" id="button" outline>선택</Button><Button size="sm" id="button1" outline
						>조회</Button
					><Button size="sm" id="button2" outline>추가</Button><Button
						size="sm"
						id="button3"
						outline>복사</Button
					><Button size="sm" id="button4" outline>삭제</Button>
				</div></Card
			>
		</div>
	</div>
	<div class="grid grid-cols-1 xl:grid-cols-1 xl:gap-4 mt-8">
		<AgGrid gridName="Title" {gridOptions} />
	</div>
</main>
