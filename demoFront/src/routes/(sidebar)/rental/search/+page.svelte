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
        console.log('newData', newData);
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

    // Form Info
    const menuName = '렌탈관리';
    const formName = '렌탈이력조회';
    let formData = [
        {
            objTyp: 'input',
            label: '이름',
            type: 'text',
            placeholder: '이름',
            id: 'empName'
        },
        {
            objTyp: 'input',
            label: 'Serial No.',
            type: 'text',
            placeholder: 'Serial No.',
            id: 'serialNo'
        },
        {
            objTyp: 'select',
            label: 'Y/N',
            type: 'select',
            id: 'dispatch',
            items: [
                {value: 'Y', name: 'Y'},
                {value: 'N', name: 'N'}
            ]
        }
    ];

    function requestRental() {
        const objectifiedFormData = formData.reduce((accumulator, current) => {
            accumulator[current.id] = current.value === undefined ? null : current.value;
            return accumulator;
        }, {});
        console.log('objectifiedFormData', objectifiedFormData);

        fetch('http://localhost:8080/find/rental', {
            method: 'POST', // HTTP 메서드 설정
            headers: {
                'Content-Type': 'application/json' // 내용 유형 헤더 설정
            },
            body: JSON.stringify(objectifiedFormData) // JavaScript 객체를 JSON 문자열로 변환
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // 응답을 JSON으로 파싱
            })
            .then((data) => {
                //console.log('Success:', data); // 성공 처리 로직
                updateGridOptions(data);
            })
            .catch((error) => {
                console.error('Error:', error); // 오류 처리 로직
            });
    }

    // After DOM loading
    onMount(() => {
        requestRental();
    });
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
            <Card size="xl">
                <Heading tag="h3" class="mb-4 text-xl font-medium tracking-wide dark:text-white">{formName}</Heading>
                <form class="grid grid-cols-4 gap-4">
                    {#each formData as {objTyp, label, id, type, placeholder, value, items}}
                        {#if objTyp === 'input'}
                            <Label class="space-y-2 col-span-1 sm:col-span-1">
                                <span>{label}</span>
                                <Input class="font-normal"
                                       {id}
                                       {type}
                                       {placeholder}
                                       {value}
                                       on:change={changeInput}
                                />
                            </Label>
                        {/if}
                        {#if objTyp === 'select'}
                            <Label class="space-y-2 col-span-1 sm:col-span-1">
                                <span>{label}</span>
                                <Select {id} class="font-normal" {items} on:change={changeInput}/>
                            </Label>
                        {/if}
                    {/each}
                </form>
                <div class="grid grid-cols-6 gap-6 mt-6 ">
                    <Button size="sm" outline on:click={requestRental}>조회</Button>
                </div>
            </Card>
        </div>
    </div>
    <div class="grid grid-cols-1 xl:grid-cols-1 xl:gap-4 mt-8">
        <AgGrid gridName="렌탈관리:이력조회" {gridOptions}/>
    </div>
</main>
