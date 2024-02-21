<script>
	// @ts-nocheck
	import { Breadcrumb, BreadcrumbItem, Heading } from 'flowbite-svelte';
	import CustForm from '../../dashboard/CustForm.svelte';
	import AgGrid from '$lib/grid/AgGrid.svelte';
	import { testdata } from './testdata.js';

	// Form Info
	const menuName = '렌탈관리';
	const formName = '렌탈이력조회';
	let formData = [
		{ objTyp: 'input', label: '이름', type: 'text', placeholder: '이름', id: 'name' },
		{ objTyp: 'input', label: 'Serial No.', type: 'text', placeholder: 'Serial No.', id: 'sn' },
		{
			objTyp: 'select', label: 'Y/N', type: 'select', id: 'yn', items: [
				{ value: 'Y', name: 'Y' },
				{ value: 'N', name: 'N' }
			]
		}
	];

	// Grid Info
	// 가져온 데이터를 기반으로 key를 컬럼명세의 field값으로 사용
	const dataKeys = Object.keys(testdata[0]);
	const columnDefs = dataKeys.map(key => {
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
	// 위 컬럼 데피니션의 필드와 아래 로우데이터의 키가 일치하면 자동으로 Init

	// 실제 그리드로 전달되는 옵션
	const gridOptions = {
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
		rowData: testdata,
		autoSizeStrategy: {
			type: 'fitCellContents'
		},
		localeText: { noRowsToShow: '조회 결과가 없습니다.' },
		rowHeight: 30
	};


	function handleFormDataChange(event) {
		formData = event.detail
		console.log('formData', formData);
	}
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

	<Heading tag="h1" class="mb-4 font-semibold tracking-wide text-xl sm:text-2xl">
		렌탈이력조회
	</Heading>

	<div class="grid grid-cols-1 pt-2 xl:grid-cols-1 xl:gap-4 dark:bg-gray-900">
		<div class="col-span-2 space-y-4">
			<CustForm formName={formName} formData={formData} on:formDataChange={handleFormDataChange} />
		</div>
	</div>
	<div class="grid grid-cols-1 xl:grid-cols-1 xl:gap-4 mt-8">
		<AgGrid gridName="테스트 그리드"
						gridOptions={gridOptions}
		/>
	</div>

</main>
